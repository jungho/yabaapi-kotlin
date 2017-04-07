package ca.architech.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Simple RestController to demonstrate OAuth2 Authorized Code Grant flow
 */
@RestController
@RequestMapping("/api/posts")
class BlogController(@Autowired
                     val repository: PostRepository) {

    @GetMapping()
    fun getPosts(): ResponseEntity<Array<Post>> {
        val posts = repository.findAll().toTypedArray()
        return ResponseEntity(posts, HttpStatus.OK)
    }

    @GetMapping(value = "/{id}")
    fun getPost(@PathVariable id: String): ResponseEntity<Post> {
        val post = repository.findOne(id)
        return ResponseEntity(post, HttpStatus.OK)
    }

    @PostMapping()
    fun createPost(post: Post): ResponseEntity<HttpStatus> {
        repository.insert(post)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: String): ResponseEntity<HttpStatus> {
        repository.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }
}