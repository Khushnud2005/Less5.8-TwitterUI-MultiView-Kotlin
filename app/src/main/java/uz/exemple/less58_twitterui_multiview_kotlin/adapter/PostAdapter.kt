package uz.exemple.less58_twitterui_multiview_kotlin.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import uz.exemple.less58_twitterui_multiview_kotlin.R
import uz.exemple.less58_twitterui_multiview_kotlin.model.Post

class PostAdapter(var context: Context, var items: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }
    val ITEM_DOUBLE_PHOTO_VIEW = 0
    val ITEM_PHOTO_VIEW = 1
    val ITEM_VIDEO_VIEW = 2

    override fun getItemViewType(position: Int): Int {
        var item = items[position]
        if(item.photo2 != 0){
            return ITEM_DOUBLE_PHOTO_VIEW
        }else if(item.video !=null){
            return ITEM_VIDEO_VIEW
        }
        return ITEM_PHOTO_VIEW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_DOUBLE_PHOTO_VIEW){
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_2xphoto_post, parent, false)
            return DoublePhotoViewHolder(view)
        }else  if( viewType == ITEM_VIDEO_VIEW){
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_video_post, parent, false)
            return VideoHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var feed = items[position]

        if (holder is FeedViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_post = holder.iv_post
            var tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.profile)
            iv_post.setImageResource(feed.photo)
            tv_fullname.text = feed.fullname
        }
        if (holder is DoublePhotoViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_post = holder.iv_post
            var iv_post2 = holder.iv_post2
            var tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.profile)
            iv_post.setImageResource(feed.photo)
            iv_post2.setImageResource(feed.photo2)
            tv_fullname.text = feed.fullname
        }
        if (holder is VideoHolder) {
            var iv_profile = holder.iv_profile
            var vv_video = holder.vv_video
            var tv_fullname = holder.tv_fullname
            context = holder.itemView.getContext()
            iv_profile.setImageResource(feed.profile)
            tv_fullname.text = feed.fullname
            val path ="android.resource://uz.exemple.less58_twitterui_multiview_java/"+R.raw.vidi
            vv_video.setVideoPath("android.resource://${context.getPackageName()}/raw/"+feed.video)
            //vv_video.setVideoPath(path)

            //vv_video.setVideoURI(Uri.parse(path))
            val mediaController = MediaController(context)

            vv_video.setMediaController(mediaController)
            vv_video.requestFocus()
            vv_video.start()
        }
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_post: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post = view.findViewById(R.id.iv_post)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
    class DoublePhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_post: ShapeableImageView
        var iv_post2: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_post = view.findViewById(R.id.iv_post)
            iv_post2 = view.findViewById(R.id.iv_post2)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
    class VideoHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var vv_video: VideoView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            vv_video = view.findViewById(R.id.vv_video_post)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
}