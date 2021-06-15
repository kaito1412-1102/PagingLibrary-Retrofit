package com.example.paginglibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.paginglibrary.model.MyItem;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

@SuppressWarnings("deprecation")
class MyItemAdapter extends PagedListAdapter<MyItem, MyItemAdapter.ItemViewHolder> {
    private Context mContext;

    protected MyItemAdapter(Context context) {
        super(DIFF_CALLBACK);
        mContext = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        MyItem item = getItem(position);
        holder.bindView(item);
    }

    public static DiffUtil.ItemCallback<MyItem> DIFF_CALLBACK = new DiffUtil.ItemCallback<MyItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull MyItem oldItem, @NonNull MyItem newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull MyItem oldItem, @NonNull MyItem newItem) {
            return oldItem.equals(newItem);
        }
    };

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ItemViewHolder(@androidx.annotation.NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }

        public void bindView(MyItem data) {
            textView.setText(data.getName());
            Glide.with(mContext).load(data.getImage())
                    .diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }
    }

}
