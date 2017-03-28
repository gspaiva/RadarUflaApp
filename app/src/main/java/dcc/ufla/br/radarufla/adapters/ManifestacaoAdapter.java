package dcc.ufla.br.radarufla.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import dcc.ufla.br.radarufla.R;
import dcc.ufla.br.radarufla.responsehttp.ManifestacaoResponse;


public class ManifestacaoAdapter extends RecyclerView.Adapter<ManifestacaoAdapter.ManifestacaoHolder> {

    private List<ManifestacaoResponse> manifestacaoResponses;
    private Context c;
    private LayoutInflater l;


    public ManifestacaoAdapter(List<ManifestacaoResponse>manifestacaoResponses,Context c ){

        this.manifestacaoResponses = manifestacaoResponses;
        this.c = c;
        this.l = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public ManifestacaoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = l.inflate(R.layout.manifestacao_item,parent,false);
        ManifestacaoHolder m = new ManifestacaoHolder(v);

        return m;
    }

    @Override
    public void onBindViewHolder(ManifestacaoHolder holder, int position) {

        Uri uri = Uri.parse("http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Bonsai_IMG_6404.jpg/440px-Bonsai_IMG_6404.jpg");
        holder.imageView.setImageURI(uri);

        holder.txtDescricao.setText("Descrição: " + manifestacaoResponses.get(position).getDescricao());
        holder.txtTipo.setText("Tipo : " + manifestacaoResponses.get(position).getTipo());
        holder.txtAssunto.setText("Assunto: " + manifestacaoResponses.get(position).getAssunto());
        holder.txtDeslikes.setText("Deslikes: " + manifestacaoResponses.get(position).getDislikes());
        holder.txtLikes.setText("Likes: " + manifestacaoResponses.get(position).getLikes());

    }

    @Override
    public int getItemCount() {
        return manifestacaoResponses.size();
    }

    public class ManifestacaoHolder extends RecyclerView.ViewHolder{

        TextView txtTipo;
        TextView txtAssunto;
        TextView txtDescricao;
        SimpleDraweeView imageView;
        TextView txtLikes;
        TextView txtDeslikes;


        public ManifestacaoHolder(View itemView) {
            super(itemView);
            this.txtLikes = (TextView)itemView.findViewById(R.id.txtLikes);
            this.txtDeslikes = (TextView)itemView.findViewById(R.id.txtdeslikes);
            this.imageView = (SimpleDraweeView) itemView.findViewById(R.id.imgManifestacao) ;
            this.txtAssunto = (TextView)itemView.findViewById(R.id.txtAssunto);
            this.txtDescricao = (TextView)itemView.findViewById(R.id.txtDescricao);
            this.txtTipo = (TextView)itemView.findViewById(R.id.txtTipoManifestacao);

        }
    }
}
