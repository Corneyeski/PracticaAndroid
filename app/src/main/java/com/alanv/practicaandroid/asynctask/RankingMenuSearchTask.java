package com.alanv.practicaandroid.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import com.alanv.practicaandroid.Entities.GameRanking;
import com.alanv.practicaandroid.Entities.ReceivedGame;
import com.alanv.practicaandroid.R;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by alanv on 15/01/2018.
 */

public class RankingMenuSearchTask extends AsyncTask<String,Integer,List<GameRanking>> {

    public interface WeakReference {
        Context getContext();
        void finished(GameRanking list);
    }
    private WeakReference ref;
    public RankingMenuSearchTask(WeakReference ref) {
        super();
        this.ref = ref;
    }

    @Override
    protected List<GameRanking> doInBackground(String... strings) {

        InputStream in = null;
        try {

            String urlStr = ref.getContext().getString(R.string.searchUrlGame);
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
            ReceivedGame list = gson.fromJson(json, ReceivedGame.class);

            return list.getData();
        }
        catch (Exception e) {
            Log.e("alan", e.getMessage());
            return null;
        }
        finally {
            try { if (in != null) in.close(); } catch (Exception ignored) { }
        }
    }

    //@Override
    public void onPostExecute(GameRanking result) {
        ref.finished(result);
    }
}
