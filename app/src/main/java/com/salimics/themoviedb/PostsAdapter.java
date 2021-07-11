package com.salimics.themoviedb;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Results> posts;

    public PostsAdapter(List<Results> posts) {
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Results post = posts.get(position);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.post.setText(Html.fromHtml(post.getName(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.post.setText(Html.fromHtml(post.getOverview()));
        }*/
        holder.post.setText(post.getTitle());
        holder.site.setText(post.getOverview());
    }

    @Override
    public int getItemCount() {
        if (posts == null) {
            return 0;
        } else {
            return posts.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView post;
        TextView site;

        public ViewHolder(View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.postitem_post);
            site = (TextView) itemView.findViewById(R.id.postitem_site);
        }
    }
}
