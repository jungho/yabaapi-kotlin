package ca.architech.api

import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

@Document(collection = "posts")
class Post (val id: String, val categories: String, val content: String) : Serializable