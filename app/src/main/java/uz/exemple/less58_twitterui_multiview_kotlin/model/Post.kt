package uz.exemple.less58_twitterui_multiview_kotlin.model

import android.provider.MediaStore

class Post {
     var profile:Int = 0
     var photo:Int = 0
     lateinit var fullname:String
     var photo2:Int=0
     var video: String? = null

    constructor(profile:Int, fullname:String, video: String){
        this.profile = profile
        this.fullname = fullname
        this.video = video
    }
    constructor(profile:Int, fullname:String, photo:Int){
        this.profile = profile
        this.fullname = fullname
        this.photo = photo
    }
    constructor(profile:Int, fullname:String, photo:Int,photo2:Int,){
        this.profile = profile
        this.fullname = fullname
        this.photo = photo
        this.photo2 = photo2
    }

}
