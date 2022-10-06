package com.example.risingtest.src.main.myPage.signup

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import com.example.risingtest.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet_dialog.*

class confirm_dialog(context: Context) : BottomSheetDialog(context) {

    init {

        val view: View = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
        setContentView(view)

        dialog_close.setOnClickListener {
        dismiss()
         }

        dialogCheckall_false.setOnClickListener{
            dialogCheckall_false.visibility=View.INVISIBLE
            dialogCheckall_true.visibility=View.VISIBLE
            dialogCheck1st_false.visibility=View.INVISIBLE
            dialogCheck1st_true.visibility=View.VISIBLE
            dialogCheck2nd_false.visibility=View.INVISIBLE
            dialogCheck2nd_true.visibility=View.VISIBLE
            dialogCheck3rd_false.visibility=View.INVISIBLE
            dialogCheck3rd_true.visibility=View.VISIBLE
            dialogCheck4th_false.visibility=View.INVISIBLE
            dialogCheck4th_true.visibility=View.VISIBLE
            bottom_false.visibility=View.INVISIBLE
            bottom_blue.visibility=View.VISIBLE
            dialog_btn_next_gray.visibility=View.INVISIBLE
            dialog_btn_next_pink.visibility=View.VISIBLE
        }

        dialogCheckall_true.setOnClickListener {
            dialogCheckall_false.visibility=View.VISIBLE
            dialogCheckall_true.visibility=View.INVISIBLE
            dialogCheck1st_false.visibility=View.VISIBLE
            dialogCheck1st_true.visibility=View.INVISIBLE
            dialogCheck2nd_false.visibility=View.VISIBLE
            dialogCheck2nd_true.visibility=View.INVISIBLE
            dialogCheck3rd_false.visibility=View.VISIBLE
            dialogCheck3rd_true.visibility=View.INVISIBLE
            dialogCheck4th_false.visibility=View.VISIBLE
            dialogCheck4th_true.visibility=View.INVISIBLE
            bottom_false.visibility=View.VISIBLE
            bottom_blue.visibility=View.INVISIBLE
            dialog_btn_next_gray.visibility=View.VISIBLE
            dialog_btn_next_pink.visibility=View.INVISIBLE
        }

        dialogCheck1st_false.setOnClickListener {
            dialogCheck1st_false.visibility=View.INVISIBLE
            dialogCheck1st_true.visibility=View.VISIBLE
            dialog_btn_next_gray.visibility=View.INVISIBLE
            dialog_btn_next_pink.visibility=View.VISIBLE
        }

        dialogCheck1st_true.setOnClickListener {
            dialogCheck1st_false.visibility=View.VISIBLE
            dialogCheck1st_true.visibility=View.INVISIBLE
            dialog_btn_next_gray.visibility=View.VISIBLE
            dialog_btn_next_pink.visibility=View.INVISIBLE
        }

        dialog_btn_next_pink.setOnClickListener{
            val intent = Intent(context, SignUpSecondActivity::class.java)
            getContext().startActivity(intent)
        }




    }

}