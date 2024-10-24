package com.tinyroom.spring.roomheart.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomHeart is a Querydsl query type for RoomHeart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomHeart extends EntityPathBase<RoomHeart> {

    private static final long serialVersionUID = -2134757281L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomHeart roomHeart = new QRoomHeart("roomHeart");

    public final com.tinyroom.spring.member.domain.QMember member;

    public final com.tinyroom.spring.room.domain.QRoom room;

    public final NumberPath<Integer> room_heart_id = createNumber("room_heart_id", Integer.class);

    public QRoomHeart(String variable) {
        this(RoomHeart.class, forVariable(variable), INITS);
    }

    public QRoomHeart(Path<? extends RoomHeart> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomHeart(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomHeart(PathMetadata metadata, PathInits inits) {
        this(RoomHeart.class, metadata, inits);
    }

    public QRoomHeart(Class<? extends RoomHeart> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.tinyroom.spring.member.domain.QMember(forProperty("member")) : null;
        this.room = inits.isInitialized("room") ? new com.tinyroom.spring.room.domain.QRoom(forProperty("room"), inits.get("room")) : null;
    }

}

