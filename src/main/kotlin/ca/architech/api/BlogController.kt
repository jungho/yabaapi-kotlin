package ca.architech.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.servlet.http.HttpServletResponse

/**
 * Simple RestController to demonstrate OAuth2 Authorized Code Grant flow
 */
@RestController
@RequestMapping("/api/posts")
class BlogController(@Autowired
                     val repository: PostRepository) {

    @GetMapping()
    fun getPosts(): List<Post> {
        return repository.findAll()
    }

    @GetMapping(value = "/{id}")
    fun getPost(@PathVariable id: String, response: HttpServletResponse): Post? {
        val post = repository.findById(id)
        if(post == null) response.status = 404 //NOT FOUND
        return post
    }

    @PostMapping()
    fun createPost(@RequestBody post: Post): ResponseEntity<HttpStatus> {
        val newPost = repository.insert(post)
        val uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPost.id)
                .toUri()
        return ResponseEntity.created(uri).build()
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: String): ResponseEntity<HttpStatus> {
        val post = repository.findById(id)

        if(post != null) {
            repository.delete(id)
            return ResponseEntity(HttpStatus.ACCEPTED)
        }

        return ResponseEntity(HttpStatus.NOT_FOUND)
    }
}