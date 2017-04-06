package ca.architech.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Simple RestController to demonstrate OAuth2 Authorized Code Grant flow
 */
@RestController
class BlogController(@Autowired
                     val repository: PostRepository) {

    @RequestMapping("/api/posts")
    fun getPosts() : Array<Post> {
        return repository.findAll().toTypedArray()
    }
    @RequestMapping("/api/posts:id")
    fun getPost(id: String) : Post {
        return repository.findOne(id)
    }

    @PostMapping("/api/posts")
    fun createPost(post: Post) {
        repository.insert(post)
    }

    @DeleteMapping("/api/posts:id")
    fun deletePost(id: String) {
        repository.delete(id)
    }
}