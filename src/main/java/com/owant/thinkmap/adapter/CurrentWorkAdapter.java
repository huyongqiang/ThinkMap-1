package com.owant.thinkmap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.owant.thinkmap.R;
import com.owant.thinkmap.model.CurrentFileModel;
import com.owant.thinkmap.view.RecycleItemClickListener;

import java.util.ArrayList;

/**
 * Created by owant on 27/02/2017.
 */

public class CurrentWorkAdapter extends RecyclerView.Adapter<CurrentWorkAdapter.CurrentFileViewHold> {

    public Context mContext;
    public ArrayList<CurrentFileModel> mLists;

    public RecycleItemClickListener mRecycleItemClickListener;

    public CurrentWorkAdapter(Context mContext, ArrayList<CurrentFileModel> mLists) {
        this.mContext = mContext;
        this.mLists = mLists;
    }

    @Override
    public CurrentFileViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_current_file, parent, false);
        CurrentFileViewHold currentFileViewHold = new CurrentFileViewHold(
                view,
                mRecycleItemClickListener);

        return currentFileViewHold;
    }

    @Override
    public void onBindViewHolder(CurrentFileViewHold holder, int position) {
        CurrentFileModel fileModel = mLists.get(position);
        holder.rootValue.setText(fileModel.mapRoot);
        holder.filePath.setText(fileModel.filePath);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public void setRecycleItemClickListener(RecycleItemClickListener recycleItemClickListener) {
        mRecycleItemClickListener = recycleItemClickListener;
    }

    static class CurrentFileViewHold extends RecyclerView.ViewHolder {
        private TextView rootValue;
        private TextView filePath;
        private RecycleItemClickListener mListener;

        public CurrentFileViewHold(final View itemView, RecycleItemClickListener listener) {
            super(itemView);
            rootValue = (TextView) itemView.findViewById(R.id.owant_file_root_value);
            filePath = (TextView) itemView.findViewById(R.id.owant_file_path);
            mListener = listener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onItemClick(itemView, getAdapterPosition());
                    }
                }
            });
        }
    }
}
