package uz.exemple.less58_twitterui_multiview_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less58_twitterui_multiview_kotlin.adapter.PostAdapter
import uz.exemple.less58_twitterui_multiview_kotlin.adapter.StoryAdapter
import uz.exemple.less58_twitterui_multiview_kotlin.model.Post
import uz.exemple.less58_twitterui_multiview_kotlin.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerStory: RecyclerView
    lateinit var recyclerFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerStory = findViewById(R.id.recyclerStory)
        recyclerStory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)

        refreshStoryAdapter(getAllStories())
        refreshFeedAdapter(getAllFeeds())
    }

    fun refreshStoryAdapter(stories: ArrayList<Story>) {
        val adapter = StoryAdapter(this, stories)
        recyclerStory.adapter = adapter
    }

    fun refreshFeedAdapter(posts: ArrayList<Post>) {
        val adapter = PostAdapter(this, posts)
        recyclerFeed.adapter = adapter
    }

    fun getAllStories(): ArrayList<Story> {
        val stories = ArrayList<Story>()
        stories.add(Story(R.drawable.profile1, "Queen"))
        stories.add(Story(R.drawable.profile2, "Farkhod"))
        stories.add(Story(R.drawable.profile3, "Xushnudbek"))
        stories.add(Story(R.drawable.profile4, "Moonlight"))
        stories.add(Story(R.drawable.profile5, "KunUz"))
        stories.add(Story(R.drawable.profile6, "Muhammad"))
        stories.add(Story(R.drawable.profile1, "Queen"))
        stories.add(Story(R.drawable.profile2, "Farkhod"))
        stories.add(Story(R.drawable.profile3, "Xushnudbek"))
        return stories
    }

    fun getAllFeeds(): ArrayList<Post> {
        val posts = ArrayList<Post>()

        posts.add(Post(R.drawable.profile3, "Xushnudbek Hudayberdiev", R.drawable.photo1))
        posts.add(Post(R.drawable.profile1, "Queen\uD83D\uDC51", R.drawable.photo5,R.drawable.photo6))
        posts.add(Post(R.drawable.profile2, "Farkhod Fayzullaev", R.drawable.photo3))
        posts.add(Post(R.drawable.profile4, "Moonlight", "vidi"))
        posts.add(Post(R.drawable.profile5, "KunUz", R.drawable.photo8))
        posts.add(Post(R.drawable.profile6, "Muhammad", R.drawable.photo7))
        posts.add(Post(R.drawable.profile1, "Queen\uD83D\uDC51", R.drawable.photo2))
        return posts
    }
}