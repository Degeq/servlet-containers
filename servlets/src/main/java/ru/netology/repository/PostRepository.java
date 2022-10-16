package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

// Stub
public class PostRepository {

  ConcurrentHashMap<Long, Post> postStock = new ConcurrentHashMap<>();
  public List<Post> all() {
    return postStock.values().stream()
            .collect(Collectors.toList());
  }

  public Optional<Post> getById(long id) {
    return Optional.ofNullable(postStock.get(id));
  }

  public Post save(Post post) {
    if (post.getId() == 0) {
      post = new Post(post.getContent());
      postStock.put(post.getId(), post);
    } else {
      if (postStock.containsKey(post.getId())) {
        postStock.get(post.getId()).setContent(post.getContent());
      } else {
        throw new NotFoundException();
      }
    }
    return post;
  }

  public void removeById(long id) {
    if (postStock.contains(id)) {
      postStock.remove(id);
    } else {
      throw new NotFoundException();
    }
  }
}
