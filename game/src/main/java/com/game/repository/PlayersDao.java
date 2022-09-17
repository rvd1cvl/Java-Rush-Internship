package com.game.repository;

import com.game.controller.filters.PlayerFilter;
import com.game.entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.TransactionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PlayersDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Player> getPlayers(PlayerFilter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Player> criteriaQuery = criteriaBuilder.createQuery(Player.class);
        Root<Player> root = criteriaQuery.from(Player.class);
        criteriaQuery.select(root);

        if (filter.getAfter() != null) {


        }

        if (filter.getBanned() != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("banned"), filter.getBanned()));

        }

        if (filter.getBefore() != null) {

        }

        if (filter.getName() != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("name"), filter.getName()));
        }

        if (filter.getProfession() != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("profession"), filter.getProfession()));

        }

        if (filter.getMaxExperience() != null) {

        }

        if (filter.getMinExperience() != null) {

        }

        if (filter.getRace() != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("race"), filter.getRace()));

        }

        if (filter.getTitle() != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("title"), filter.getTitle()));

        }

        if (filter.getPageNumber() != null) {

        }

        if (filter.getPageSize() != null) {

        }

        if (filter.getOrder() != null) {
            switch (filter.getOrder()) {
                case ID:
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
            }


        }

        Query query = entityManager.createQuery(criteriaQuery);
        List<Player> resultList = query.getResultList();


        return resultList;
    }
}
