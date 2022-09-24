package com.game.repository;

import com.game.controller.filters.PlayerFilter;
import com.game.entity.Player;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PlayersDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Player> getPlayers(PlayerFilter filter, boolean forCounting) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Player> criteriaQuery = criteriaBuilder.createQuery(Player.class);
        Root<Player> root = criteriaQuery.from(Player.class);
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getAfter() != null) {
            if (filter.getBefore() != null) {
                predicates.add(criteriaBuilder.between(root.get("birthday"), filter.getAfter(), filter.getBefore()));
            } else {
                predicates.add(criteriaBuilder.between(root.get("birthday"), filter.getAfter(), new Date()));
            }
        } else {
            if (filter.getBefore() != null) {
                predicates.add(criteriaBuilder.between(root.get("birthday"), new Date(0), filter.getBefore()));
            }
        }

        if (filter.getBanned() != null) {
            predicates.add(criteriaBuilder.equal(root.get("banned"), filter.getBanned()));
        }

        if (filter.getName() != null) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + filter.getName() + "%"));
        }

        if (filter.getProfession() != null) {
           predicates.add(criteriaBuilder.equal(root.get("profession"), filter.getProfession()));
        }

        if (filter.getMaxExperience() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("experience"), filter.getMaxExperience()));
        }

        if (filter.getMinExperience() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("experience"), filter.getMinExperience()));
        }

        if (filter.getRace() != null) {
            predicates.add(criteriaBuilder.equal(root.get("race"), filter.getRace()));
        }

        if (filter.getTitle() != null) {
            predicates.add(criteriaBuilder.like(root.get("title"), "%" +  filter.getTitle() +"%"));
        }

        if (filter.getMaxLevel() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("level"), filter.getMaxLevel()));
        }

        if (filter.getMinLevel() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("level"), filter.getMinLevel()));
        }

        switch (filter.getOrder()) {
            case ID:
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
                break;
            case NAME:
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));
                break;
            case LEVEL:
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("level")));
                break;
            case BIRTHDAY:
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("birthday")));
                break;
            case EXPERIENCE:
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("experience")));
                break;
        }

        criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));

        Query query = entityManager.createQuery(criteriaQuery);

        if (!forCounting) {
            query.setMaxResults(filter.getPageSize());
            query.setFirstResult(filter.getPageSize() * filter.getPageNumber());
        }

        return query.getResultList();
    }
}
