package com.alexbbb.uploadservice;

/**
 * @author AZ Aizaz
 */

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.provider.MediaStore.Files;

public abstract class AbstractFileUploadResultReceiver extends ResultReceiver {

    public AbstractFileUploadResultReceiver(Handler handler) {
        super(handler);
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
        
        if(resultCode == UploadService.CODE_RESULT_UPLOAD_FILES){
            ArrayList<FileToUpload> list = resultData.getParcelableArrayList(UploadService.KEY_RESULT_UPLAOD_FILES);
            String taskId = resultData.getString(UploadService.KEY_TASK_UUID); 
            this.onFilesUploadResultReceived(list, taskId);
        }
        
    }

    abstract public void onFilesUploadResultReceived(ArrayList<FileToUpload> files, final String taskid);

}
