package com.example.mobileappc3;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CarvingRepository {

    private CarvingDatabase mCarvingDatabase;

    public CarvingRepository(Context context) {
        mCarvingDatabase = CarvingDatabase.getInstance(context);
    }

    public void insertNoteTask(Carving carving){
        new InsertAsyncTask(mCarvingDatabase.getCarvingDao()).execute(carving);
    }

    public void updateNoteTask(Carving carving){
        new UpdateAsyncTask(mCarvingDatabase.getCarvingDao()).execute(carving);
    }

    public LiveData<List<Carving>> retrieveNotesTask() {
        return mCarvingDatabase.getCarvingDao().getCarvings();
    }

    public void deleteNoteTask(Carving carving){
        new DeleteAsyncTask(mCarvingDatabase.getCarvingDao()).execute(carving);
    }

    public static class InsertAsyncTask extends AsyncTask<Carving,Void,Void> {
        private CarvingDao mCarvingDao;

        public InsertAsyncTask(CarvingDao dao) {
            mCarvingDao = dao;
        }


        @Override
        protected Void doInBackground(Carving... carvings) {
            mCarvingDao.insertCarvings(carvings);
            return null;
        }
    }

    public static class DeleteAsyncTask extends AsyncTask<Carving,Void,Void>{
        private CarvingDao mCarvingDao;

        public DeleteAsyncTask(CarvingDao dao) {
            mCarvingDao = dao;
        }


        @Override
        protected Void doInBackground(Carving... carvings) {
            mCarvingDao.deleteCarvings(carvings);
            return null;
        }
    }

    public static class UpdateAsyncTask extends AsyncTask<Carving,Void,Void>{
        private CarvingDao mCarvingDao;

        public UpdateAsyncTask(CarvingDao dao) {
            mCarvingDao = dao;
        }


        @Override
        protected Void doInBackground(Carving... carvings) {
            mCarvingDao.updateCarvings(carvings);
            return null;
        }
    }
}
