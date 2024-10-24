package com.tinyroom.spring.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 951964875L;

    public static final QMember member = new QMember("member1");

    public final StringPath description = createString("description");

    public final StringPath email = createString("email");

    public final NumberPath<Integer> is_active = createNumber("is_active", Integer.class);

    public final NumberPath<Integer> member_id = createNumber("member_id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath phone_number = createString("phone_number");

    public final StringPath profile_img = createString("profile_img");

    public final StringPath pw = createString("pw");

    public final StringPath type = createString("type");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

