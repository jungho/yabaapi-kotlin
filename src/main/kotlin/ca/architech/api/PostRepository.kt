package ca.architech.api

import org.springframework.data.mongodb.repository.MongoRepository

interface PostRepository : MongoRepository<Post, String> {
    override fun findAll(): MutableList<Post> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findOne(id: String?): Post {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Post?> insert(entity: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}