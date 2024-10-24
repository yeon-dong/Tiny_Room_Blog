package com.tinyroom.spring.postheart.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostHeart is a Querydsl query type for PostHeart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostHeart extends EntityPathBase<PostHeart> {

    private static final long serialVersionUID = 728953279L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPostHeart postHeart = new QPostHeart("postHeart");

    public final NumberPath<Integer> is_active = createNumber("is_active", Integer.class);

    public final com.tinyroom.spring.member.domain.QMember member;

    public final com.tinyroom.spring.post.domain.QPost post;

    public final NumberPath<Integer> post_heart_id = createNumber("post_heart_id", Integer.class);

    public QPostHeart(String variable) {
        this(PostHeart.class, forVariable(variable), INITS);
    }

    public QPostHeart(Path<? extends PostHeart> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPostHeart(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPostHeart(PathMetadata metadata, PathInits inits) {
        this(PostHeart.class, metadata, inits);
    }

    public QPostHeart(Class<? extends PostHeart> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.tinyroom.spring.member.domain.QMember(forProperty("member")) : null;
        this.post = inits.isInitialized("post") ? new com.tinyroom.spring.post.domain.QPost(forProperty("post"), inits.get("post")) : null;
    }

}

