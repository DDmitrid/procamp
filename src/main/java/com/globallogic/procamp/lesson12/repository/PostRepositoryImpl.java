package com.globallogic.procamp.lesson12.repository;

import org.springframework.stereotype.Repository;

import com.globallogic.procamp.lesson12.entity.onetoone.mapsid.Post;
import com.globallogic.procamp.lesson12.repository.onetoone.mapsid.PostRepository;

@Repository
public class PostRepositoryImpl extends BaseRepositoryImpl<Post, Long> implements PostRepository {
}
