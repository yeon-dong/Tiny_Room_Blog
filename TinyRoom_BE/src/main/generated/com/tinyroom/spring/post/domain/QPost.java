package com.tinyroom.spring.post.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 358474455L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final com.tinyroom.spring.category.domain.QCategory category;

    public final ListPath<com.tinyroom.spring.comment.domain.Comment, com.tinyroom.spring.comment.domain.QComment> comments = this.<com.tinyroom.spring.comment.domain.Comment, com.tinyroom.spring.comment.domain.QComment>createList("comments", com.tinyroom.spring.comment.domain.Comment.class, com.tinyroom.spring.comment.domain.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final NumberPath<Integer> is_active = createNumber("is_active", Integer.class);

    public final com.tinyroom.spring.member.domain.QMember member;

    public final NumberPath<Integer> post_id = createNumber("post_id", Integer.class);

    public final StringPath post_img = createString("post_img");

    public final StringPath text_content = createString("text_content");

    public final StringPath thumbnail = createString("thumbnail");

    public final StringPath title = createString("title");

    public final DatePath<java.time.LocalDate> w_date = createDate("w_date", java.time.LocalDate.class);

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new com.tinyroom.spring.category.domain.QCategory(forProperty("category")) : null;
        this.member = inits.isInitialized("member") ? new com.tinyroom.spring.member.domain.QMember(forProperty("member")) : null;
    }

}

