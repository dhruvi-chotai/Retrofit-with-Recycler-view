package com.example.retrofit_with_recyclerview_mvp.View
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_with_recyclerview.R
import com.example.retrofit_with_recyclerview_mvp.model.Post

// Create a RecyclerView adapter PostAdapter to bind the data to the views:


class PostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        private val bodyTextView = itemView.findViewById<TextView>(R.id.bodyTextView)
        private var id = itemView.findViewById<TextView>(R.id.id)

        fun bind(post: Post) {
            id.text = post.id.toString()
            titleTextView.text = post.title
            bodyTextView.text = post.body
        }
    }
}


























/*      • class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>():
        ◦ This line declares the PostAdapter class that extends the RecyclerView.Adapter class and uses the ViewHolder inner class.
        ◦ The class takes a parameter posts of type List<Post> in the primary constructor, which represents the list of posts to be displayed in the RecyclerView.
kotlinCopy code
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
    return ViewHolder(view)
}
    • override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder:
        ◦ This function is overridden from the RecyclerView.Adapter class and is responsible for creating the ViewHolder objects.
    • val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false):
        ◦ This line inflates the layout resource R.layout.item_post to create the view for each item in the RecyclerView. It uses the LayoutInflater to inflate the layout.
    • return ViewHolder(view):
        ◦ This line returns a new instance of the ViewHolder class, passing the inflated view as the constructor parameter.
kotlinCopy code
override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val post = posts[position]
    holder.bind(post)
}
    • override fun onBindViewHolder(holder: ViewHolder, position: Int):
        ◦ This function is overridden from the RecyclerView.Adapter class and is responsible for binding the data to the views in each ViewHolder.
    • val post = posts[position]:
        ◦ This line retrieves the Post object from the posts list based on the position parameter.
    • holder.bind(post):
        ◦ This line calls the bind() function in the ViewHolder class and passes the Post object to bind the data to the views.
kotlinCopy code
override fun getItemCount(): Int {
    return posts.size
}
    • override fun getItemCount(): Int:
        ◦ This function is overridden from the RecyclerView.Adapter class and returns the total number of items in the posts list.
    • return posts.size:
        ◦ This line returns the size of the posts list, which represents the number of items in the RecyclerView.
kotlinCopy code
inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
    private val bodyTextView = itemView.findViewById<TextView>(R.id.bodyTextView)

    fun bind(post: Post) {
        titleTextView.text = post.title
        bodyTextView.text = post.body
    }
}
    • inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView):
        ◦ This line declares the inner ViewHolder class that extends the RecyclerView.ViewHolder class. It represents a single item view in the RecyclerView.
    • private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView) and private val bodyTextView = itemView.findViewById<TextView>(R.id.bodyTextView):
        ◦ These lines find and assign the TextView views with IDs titleTextView and bodyTextView from the inflated itemView.
    • fun bind(post: Post):
        ◦ This function takes a Post object as a parameter and binds the data to the corresponding views in the ViewHolder.
    • titleTextView.text = post.title and bodyTextView.text = post.body:
        ◦ These lines set the text of titleTextView and bodyTextView to the title and body properties of the Post object, respectively.
In summary, the PostAdapter class is responsible for creating and binding the data to the ViewHolder objects in the RecyclerView. It inflates the item view layout, binds the data to the corresponding views, and determines the total number of items in the list. The ViewHolder inner class holds references to the individual views and binds the data to them.  */