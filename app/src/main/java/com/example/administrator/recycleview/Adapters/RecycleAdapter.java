package com.example.administrator.recycleview.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.recycleview.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.List;

/**
 * Created by Administrator on 2017/5/14 0014.
 */

public class RecycleAdapter extends RecyclerView.Adapter {

    private final int TYPE_HEAD = 0 ; //显示首个位置 ， 直接显示轮播位置
    private final int TYPE_NORMAL = 1 ; //来表示正常的item 布局
    private Context mcontext;
    private List<String> banner_url; //轮播图片的路径

    //构造方法
    public RecycleAdapter(Context context, List<String> banner_url){
        this.mcontext=context;
        this.banner_url=banner_url;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        if (viewType == TYPE_HEAD) {
            //此处要创建顶部banner的viewholder
            holder=new BannerViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.itemheader_banner,parent,false));
        }else{
            holder=new BannerViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.itemrecycle,parent,false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof BannerViewHolder){
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.banner.setImages(banner_url);
        }else if(holder instanceof ItemViewHolder){
            //处理每个item的布局
            ItemViewHolder itemViewHolder= (ItemViewHolder) holder;
            itemViewHolder.textView.setText(banner_url.get(position-1));
        }
    }

    @Override
    public int getItemCount() {
        return banner_url.size()+1;
    }


    //正常的item的布局管理
    class ItemViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleView;
        TextView textView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.newstext);
            simpleView=(SimpleDraweeView)itemView.findViewById(R.id.simpleview);
        }
    }
    //首位的banner
    class BannerViewHolder extends RecyclerView.ViewHolder {
         Banner banner;
        public BannerViewHolder(View itemView) {
            super(itemView);
             banner=(Banner)itemView.findViewById(R.id.banner);
        }
    }

}
