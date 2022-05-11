package com.hakanoguz33.brainstoragev3.views

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.model.saticiDB
import com.hakanoguz33.brainstoragev3.db.saticiDBdao
import kotlinx.android.synthetic.main.fragment_home_page.*


class homePageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = layoutInflater.inflate(R.layout.fragment_home_page,container,false)
        return tasarim
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        girisButton.setOnClickListener {
            username_password_check(editTextUserName.text.toString(),editTextPassword.text.toString())
        }
        sifreGizleImageButton.setOnClickListener{
            if (editTextPassword.transformationMethod == HideReturnsTransformationMethod.getInstance())
                editTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            else
                editTextPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }
    }
    fun username_password_check(username: String, password: String) {
        val db = context?.let { brainStorageDb(it) }
        val saticiList: List<saticiDB>? = db?.let { saticiDBdao().saticiBul(it) }
        val size: Int? = saticiList?.size
        Log.e("size:","${size}")
        for (k in 0..(size!!-1))
        {
                if (saticiList[k].satici_user_name == username && saticiList[k].satici_password == password)
                {
                        val action = homePageFragmentDirections.actionHomePageFragmentToCategoryPageFragment(saticiList[k].satici_id)
                        Navigation.findNavController(girisButton).navigate(action)
                        break
                }
                else{
                    Toast.makeText(context,"Hatalı Giriş. Kullanıcı adı ve parolanızı kontrol ediniz.",Toast.LENGTH_SHORT).show()
                }
        }
    }
}