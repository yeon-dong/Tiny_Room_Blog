package com.tinyroom.spring.neighbour.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNeighbour is a Querydsl query type for Neighbour
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNeighbour extends EntityPathBase<Neighbour> {

    private static final long serialVersionUID = 1769143999L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNeighbour neighbour = new QNeighbour("neighbour");

    public final com.tinyroom.spring.member.domain.QMember from_member;

    public final NumberPath<Integer> neighbour_id = createNumber("neighbour_id", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final com.tinyroom.spring.member.domain.QMember to_member;

    public QNeighbour(String variable) {
        this(Neighbour.class, forVariable(variable), INITS);
    }

    public QNeighbour(Path<? extends Neighbour> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNeighbour(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNeighbour(PathMetadata metadata, PathInits inits) {
        this(Neighbour.class, metadata, inits);
    }

    public QNeighbour(Class<? extends Neighbour> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.from_member = inits.isInitialized("from_member") ? new com.tinyroom.spring.member.domain.QMember(forProperty("from_member")) : null;
        this.to_member = inits.isInitialized("to_member") ? new com.tinyroom.spring.member.domain.QMember(forProperty("to_member")) : null;
    }

}

