package com.example.firstnavigation.activitys;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.base.activity.SimpleActivity;
import com.example.firstnavigation.beans.HeadImage;
import com.example.firstnavigation.contact.HeadImageCon;
import com.example.firstnavigation.json.JsonHeadImage;
import com.example.firstnavigation.presenter.HeadImagePresenter;
import com.example.firstnavigation.shujukuBeans.DataBaseHelep;
import com.example.firstnavigation.shujukuBeans.Studnet;
import com.example.firstnavigation.utils.Constants;
import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity<HeadImageCon.ListNewsConV, HeadImagePresenter<HeadImageCon.ListNewsConV>> implements HeadImageCon.ListNewsConV {

    @BindView(R.id.iv_return)
    ImageView mIvReturn;
    @BindView(R.id.iv_cha)
    ImageView mIvCha;
    @BindView(R.id.image_bighead)
    ImageView mImageBighead;
    @BindView(R.id.ed_username)
    EditText mEdUsername;
    @BindView(R.id.iv_ok)
    ImageView mIvOk;
    @BindView(R.id.te_skip)
    TextView mTeSkip;
    @BindView(R.id.linearLayout)
    LinearLayout mLinearLayout;

    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 1;
    //相机请求码
    private static final int CAMERA_REQUEST_CODE = 2;
    //剪裁请求码
    private static final int CROP_SMALL_PICTURE = 3;

    //调用照相机返回图片文件
    private File tempFile;
    //最后显示的图片文件
    private String mFile;
    private int mUserName;
    private int mS;
    private PopupWindow mPopupWindow;
    private Bitmap mPhoto;
    private String mPhone;

    @Override
    protected int getActivityColor() {
        return R.color.colorBlack;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_message;
    }

    @OnClick({R.id.iv_return, R.id.image_bighead, R.id.iv_ok, R.id.te_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_return:
                finish();
                break;
            case R.id.image_bighead:
                showPop();
                break;
            case R.id.iv_ok:
                if (mEdUsername != null && mEdUsername.length() > 0) {
                    startActivity(new Intent(MessageActivity.this,InformationActivity.class));
                    DataBaseHelep.getInsh().insert(new Studnet(null, mPhone,mEdUsername.getText().toString(),BitmaptoString(mPhoto),true));
                } else {
                    showPoPName();
                }
                break;
            case R.id.te_skip:
                break;
        }
    }

    private void showPoPName() {
        View inflate = View.inflate(MessageActivity.this, R.layout.user_name, null);
        LinearLayout lin = inflate.findViewById(R.id.lin);
        final TextView username = inflate.findViewById(R.id.tv_userName);
        Button but_que = inflate.findViewById(R.id.but_que);
        Button butxiu = inflate.findViewById(R.id.but_xiu);
        mLinearLayout.setAlpha(0.5f);
        final PopupWindow popupWindow = new PopupWindow(inflate);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        username.setText(getUserName());

        popupWindow.showAtLocation(mLinearLayout, Gravity.CENTER, 0, 0);

        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                mLinearLayout.setAlpha(1);
            }
        });
        but_que.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdUsername.setText(usernamea());
                popupWindow.dismiss();
                mLinearLayout.setAlpha(1);
            }
        });
        butxiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                mLinearLayout.setAlpha(1);
            }
        });

    }

    private void showPop() {
        View inflate = View.inflate(MessageActivity.this, R.layout.popup, null);
        mPopupWindow = new PopupWindow(inflate);
        LinearLayout layout = inflate.findViewById(R.id.layout);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);

        mPopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER, 300, 300);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
        Button btPhotograph = inflate.findViewById(R.id.bt_photograph);
        btPhotograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPhotograph();
            }
        });
        Button photo = inflate.findViewById(R.id.bt_photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPicFromAlbm();
            }
        });
    }

    private void getPicFromAlbm() {
       /* Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image*//*");
        startActivityForResult(photoPickerIntent, ALBUM_REQUEST_CODE);*/

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(intent, Constants.REQUEST_PHOTO);
        mPopupWindow.dismiss();

    }

    private void showPhotograph() {
        //用于保存调用相机拍照后所生成的文件
        tempFile = new File(Environment.getExternalStorageDirectory().getPath(), System.currentTimeMillis() + ".png");
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {   //如果在Android7.0以上,使用FileProvider获取Uri
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
            Log.e("getPicFromCamera", contentUri.toString());
        } else {    //否则使用Uri.fromFile(file)方法获取Uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    @OnClick(R.id.iv_cha)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case CAMERA_REQUEST_CODE:   //调用相机后返回
                if (resultCode == RESULT_OK) {
                    //用相机返回的照片去调用剪裁也需要对Uri进行处理
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Uri contentUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", tempFile);
                        startPhotoZoom(contentUri);//开始对图片进行裁剪处理
                    } else {
                        startPhotoZoom(Uri.fromFile(tempFile));//开始对图片进行裁剪处理
                    }
                }
                break;
            case ALBUM_REQUEST_CODE:    //调用相册后返回
                if (resultCode == RESULT_OK) {
                    Uri uri = intent.getData();
                    startPhotoZoom(uri); // 开始对图片进行裁剪处理
                }
                break;
            case CROP_SMALL_PICTURE:  //调用剪裁后返回
                if (intent != null) {
                    // 让刚才选择裁剪得到的图片显示在界面上
                    mPhoto = BitmapFactory.decodeFile(mFile);
                    mImageBighead.setImageBitmap(mPhoto);
                } else {
                    Log.e("data", "data为空");
                }
                break;
            case Constants.REQUEST_CODE_TAKE_PICTURE:
                break;
            case Constants.REQUEST_PHOTO:
                if (intent != null) {
                    Uri selectedImage = intent.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    File file1 = getFile(BitmapFactory.decodeFile(picturePath));
                    Log.d("moxun", "onActivityResult: " + file1.getPath());
                    // putheadImg.setText("更换图像");
                    HashMap<String, Object> map1 = new HashMap<>();
                    map1.put("userId", "049de01db14a4c8184faa0aca7facf8a");
                    map1.put("file", file1);
                    mPresenter.getHeadImage(map1);
                }
                break;
        }

    }

    public File getFile(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        File file = new File(Environment.getExternalStorageDirectory() + "/temp.jpg");
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            int x = 0;
            byte[] b = new byte[1024 * 100];
            while ((x = is.read(b)) != -1) {
                fos.write(b, 0, x);
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public String saveImage(String name, Bitmap bmp) {
        File appDir = new File(Environment.getExternalStorageDirectory().getPath());
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = name + ".png";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {

        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
//        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 100);
        intent.putExtra("outputY", 100);
        intent.putExtra("return-data", false);
        File out = new File(getPath());
        if (!out.getParentFile().exists()) {
            out.getParentFile().mkdirs();
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(out));
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    //裁剪后的地址
    public String getPath() {
        //resize image to thumb
        if (mFile == null) {
            mFile = Environment.getExternalStorageDirectory() + "/" + "wode/" + "outtemp.png";
        }
        return mFile;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showListNews(HeadImage headImage) {
        Log.e("uuuuuuuu", headImage.getHeadImagePath());
        Glide.with(this).load(headImage.getHeadImagePath()).into(mImageBighead);

    }

    @Override
    protected void initEvenAndData() {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                1);

        Intent intent = getIntent();
        mPhone = intent.getStringExtra("phone");


        Log.e("ppppppppppppp",mPhone);
    }

    public String BitmaptoString(Bitmap bitmap){
        //将Bitmap转换成字符串
        String string=null;
        ByteArrayOutputStream bStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bStream);
        byte[]bytes=bStream.toByteArray();
        string= Base64.encodeToString(bytes,Base64.DEFAULT);
        return string;
    }

    @Override
    protected HeadImagePresenter<HeadImageCon.ListNewsConV> createPresenter() {
        return new HeadImagePresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinearLayout;
    }

    public String getUserName() {
        StringBuffer buffer1 = new StringBuffer();
        int max = 10000000;
        int min = 99999999;
        Random random = new Random();
        mS = random.nextInt(max) % (max - min + 1) + min;
        buffer1.append("“通航用户");
        buffer1.append(mS);
        buffer1.append("”?");
        return buffer1.toString();
    }

    private String usernamea() {
        return "通航用户" + mS;
    }
}
