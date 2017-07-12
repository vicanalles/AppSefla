package appsefla.studio.com.appsefla.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import appsefla.studio.com.appsefla.R;
import appsefla.studio.com.appsefla.extras.ImageHelper;
import appsefla.studio.com.appsefla.interfaces.RecyclerViewOnClickListenerHack;
import appsefla.studio.com.appsefla.model.Produto;
import butterknife.BindView;

/**
 * Created by vinicius on 11/07/17.
 */

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.MyViewHolder> {

    private Context mContext;
    private List<Produto> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;
    private float scale;
    private int width;
    private int height;

    public ProdutoAdapter(Context c, List<Produto> l){
        mContext = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        scale = mContext.getResources().getDisplayMetrics().density;
        width = mContext.getResources().getDisplayMetrics().widthPixels - (int)(14 * scale + 0.5f);
        height = (width/16) * 9;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = mLayoutInflater.inflate(R.layout.item_produto_card, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        myViewHolder.tvNome.setText(mList.get(position).getNome());
        myViewHolder.tvDescricao.setText(mList.get(position).getDescricao());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            myViewHolder.ivProduto.setImageResource(mList.get(position).getPhoto());
        }else{
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), mList.get(position).getPhoto());
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);

            bitmap = ImageHelper.getRoundedCornerBitmap(mContext, bitmap, 4, width, height, false, false, true, true);
            myViewHolder.ivProduto.setImageBitmap(bitmap);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addListItem(Produto p, int position){
        mList.add(p);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_model) TextView tvNome;
        @BindView(R.id.tv_brand) TextView tvDescricao;
        @BindView(R.id.iv_car) ImageView ivProduto;

        public MyViewHolder(View itemView){
            super(itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mRecyclerViewOnClickListenerHack != null) {
                mRecyclerViewOnClickListenerHack.onClickListener(v, getPosition());
            }
        }
    }
}
