package com.example.mobileappc3;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WaiataRepository {

    private WaiataDatabase mWaiataDatabase;

    public WaiataRepository(Context context) {
        mWaiataDatabase = WaiataDatabase.getInstance(context);
    }

    public void insertNoteTask(Waiata Waiata){
        new InsertAsyncTask(mWaiataDatabase.getWaiataDao()).execute(Waiata);
    }

    public void updateNoteTask(Waiata Waiata){
        new UpdateAsyncTask(mWaiataDatabase.getWaiataDao()).execute(Waiata);
    }

    public LiveData<List<Waiata>> retrieveNotesTask() {
        return mWaiataDatabase.getWaiataDao().getWaiata();
    }

    public void deleteNoteTask(Waiata Waiata){
        new DeleteAsyncTask(mWaiataDatabase.getWaiataDao()).execute(Waiata);
    }

    public static class InsertAsyncTask extends AsyncTask<Waiata,Void,Void> {
        private WaiataDao mWaiataDao;

        public InsertAsyncTask(WaiataDao dao) {
            mWaiataDao = dao;
        }


        @Override
        protected Void doInBackground(Waiata... Waiatas) {
            mWaiataDao.insertWaiata(Waiatas);
            return null;
        }
    }

    public static class DeleteAsyncTask extends AsyncTask<Waiata,Void,Void>{
        private WaiataDao mWaiataDao;

        public DeleteAsyncTask(WaiataDao dao) {
            mWaiataDao = dao;
        }


        @Override
        protected Void doInBackground(Waiata... Waiatas) {
            mWaiataDao.deleteWaiata(Waiatas);
            return null;
        }
    }

    public static class UpdateAsyncTask extends AsyncTask<Waiata,Void,Void>{
        private WaiataDao mWaiataDao;

        public UpdateAsyncTask(WaiataDao dao) {
            mWaiataDao = dao;
        }


        @Override
        protected Void doInBackground(Waiata... Waiatas) {
            mWaiataDao.updateWaiata(Waiatas);
            return null;
        }
    }
}
