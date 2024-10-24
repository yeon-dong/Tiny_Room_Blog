package com.tinyroom.spring.room.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoom is a Querydsl query type for Room
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoom extends EntityPathBase<Room> {

    private static final long serialVersionUID = -881446195L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoom room = new QRoom("room");

    public final com.tinyroom.spring.blog.domain.QBlog blog;

    public final NumberPath<Integer> furniture1 = createNumber("furniture1", Integer.class);

    public final NumberPath<Integer> furniture2 = createNumber("furniture2", Integer.class);

    public final NumberPath<Integer> furniture3 = createNumber("furniture3", Integer.class);

    public final NumberPath<Integer> furniture4 = createNumber("furniture4", Integer.class);

    public final NumberPath<Integer> room_id = createNumber("room_id", Integer.class);

    public final NumberPath<Integer> room_theme = createNumber("room_theme", Integer.class);

    public QRoom(String variable) {
        this(Room.class, forVariable(variable), INITS);
    }

    public QRoom(Path<? extends Room> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoom(PathMetadata metadata, PathInits inits) {
        this(Room.class, metadata, inits);
    }

    public QRoom(Class<? extends Room> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.blog = inits.isInitialized("blog") ? new com.tinyroom.spring.blog.domain.QBlog(forProperty("blog"), inits.get("blog")) : null;
    }

}

