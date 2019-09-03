package co.xomodo.novellibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ListNovelAdapter extends RecyclerView.Adapter<ListNovelAdapter.NovelViewHolder> {
    private ArrayList<Novel> mNovelList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class NovelViewHolder extends RecyclerView.ViewHolder {
        public ImageView mNovelPhoto;
        public TextView mNovelTitle;
        public TextView mNovelWriter;
        public TextView mJudulResensi;
        public TextView mResensiPg1;
        public TextView mResensiPg2;
        public TextView mResensiPg3;

        public NovelViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mNovelPhoto = itemView.findViewById(R.id.img_novel_photo);
            mNovelTitle = itemView.findViewById(R.id.tv_novel_title);
            mNovelWriter = itemView.findViewById(R.id.tv_novel_writer);
            mJudulResensi = itemView.findViewById(R.id.tv_judul_resensi);
            mResensiPg1 = itemView.findViewById(R.id.resensi_pg_1);
            mResensiPg2 = itemView.findViewById(R.id.resensi_pg_2);
            mResensiPg3 = itemView.findViewById(R.id.resensi_pg_3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ListNovelAdapter(ArrayList<Novel> novelList) {
        mNovelList = novelList;
    }

    @Override
    public NovelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_item, parent, false);
        NovelViewHolder nvh = new NovelViewHolder(v, mListener);
        return nvh;
    }

    @Override
    public void onBindViewHolder(NovelViewHolder holder, int position) {
        Novel currentItem = mNovelList.get(position);

        holder.mNovelPhoto.setImageResource(currentItem.getNovelPhoto());
        holder.mNovelTitle.setText(currentItem.getNovelTitle());
        holder.mNovelWriter.setText(currentItem.getNovelWriter());
    }

    @Override
    public int getItemCount() {
        return mNovelList.size();
    }
}