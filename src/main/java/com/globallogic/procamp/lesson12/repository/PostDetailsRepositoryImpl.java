package com.globallogic.procamp.lesson12.repository;

import org.springframework.stereotype.Repository;

import com.globallogic.procamp.lesson12.entity.onetoone.mapsid.Post;
import com.globallogic.procamp.lesson12.entity.onetoone.mapsid.PostDetails;
import com.globallogic.procamp.lesson12.repository.onetoone.mapsid.PostDetailsRepository;
import com.globallogic.procamp.lesson12.repository.onetoone.mapsid.PostRepository;

@Repository
public class PostDetailsRepositoryImpl extends BaseRepositoryImpl<PostDetails, Long> implements PostDetailsRepository {
}
