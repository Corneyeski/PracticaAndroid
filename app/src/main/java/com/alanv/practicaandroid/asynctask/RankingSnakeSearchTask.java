package com.alanv.practicaandroid.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.alanv.practicaandroid.Entities.GameRanking;
import com.alanv.practicaandroid.R;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by alanv on 18/12/2017.
 */

public class RankingSnakeSearchTask extends AsyncTask<String,Integer,GameRanking>{

    /**
     *
      * TODO Esto es para la progress bar
     */
    public interface WeakReference {
        Context getContext();
        ProgressBar getProgressBar();
        void finished(GameRanking list);
    }
    private WeakReference ref;
    public RankingSnakeSearchTask(WeakReference ref) {
        super();
        this.ref = ref;
    }

    /**
     *
     * TODO esto muestra la barra de carga
     */
    /*@Override
    public void onPreExecute() {
        // Log.d("flx", "onPreExecute()");
        ProgressBar pb = ref.getProgressBar();
        pb.setIndeterminate(true);
        pb.setVisibility(View.VISIBLE);
    }*/

    @Override
    protected GameRanking doInBackground(String... strings) {

        InputStream in = null;
        try {
            // BUILD URL
            String search = strings[0];
            search = URLEncoder.encode(search, "utf-8");

            //TODO ApiKey no es necesaria
            // String apiKey = ref.getContext().getString(R.string.apiKey);
            String urlStr = ref.getContext().getString(R.string.searchUrlGame) + search;
            Log.d("alan", "URL " + urlStr);

            // OPEN CONNECTION
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(2000);
            conn.setReadTimeout(1000);
            int length = conn.getContentLength();

            // DOWNLOAD JSON
            in = url.openStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int total = 0, nRead;
            while ((nRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, nRead);
                total += nRead;
            }
            String json = new String(out.toByteArray());

            // DECODE JSON
            Gson gson = new Gson();
            GameRanking list = gson.fromJson(json, GameRanking.class);

            return list;
        }
        catch (Exception e) {
            Log.e("alan", e.getMessage());
            return null;
        }
        finally {
            try { if (in != null) in.close(); } catch (Exception ignored) { }
        }
    }

    /**
     * TODO esto oculta la barra de carga
     */
    /*@Override
    public void onPostExecute(GameRanking result) {
        // Log.d("flx", "onPostExecute()");
        ProgressBar pb = ref.getProgressBar();
        pb.setVisibility(View.INVISIBLE);
        ref.finished(result);
    }*/

}
