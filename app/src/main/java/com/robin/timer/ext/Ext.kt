package com.robin.timer.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.robin.timer.util.Event
import com.robin.timer.util.OnSafeClickListener
import com.robin.timer.R

/* View Visibility */
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.slideUp(context: Context) {
    startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_up))
}

fun View.slideDown(context: Context) {
    startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_down))
}

/*StartActivity*/
fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun <T> Fragment.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(requireContext(), it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

/*Toast*/
fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Activity.toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, this.resources.getText(resId), duration).show()
}

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), message, duration).show()
}

fun Fragment.toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), this.resources.getText(resId), duration).show()
}

/*SnackBar*/
inline fun View.snack(@StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    snack(resources.getString(messageRes), length, f)
}

inline fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.purple_200))
    snack.setTextColor(ContextCompat.getColor(this.context, R.color.white))
    snack.f()
    snack.show()
}

fun Snackbar.action(@StringRes actionRes: Int, color: Int? = null, listener: (View) -> Unit) {
    action(view.resources.getString(actionRes), color, listener)
}

fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(ContextCompat.getColor(context, color)) }
}

/* run Event<Unit> */
fun MutableLiveData<Event<Unit>>.runEvent() {
    value = Event(Unit)
}

/* prevent double click */
@BindingAdapter("onSafeClick")
fun View.setOnSafeClick(clickListener: View.OnClickListener?) {
    setOnClickListener(OnSafeClickListener(clickListener))
}

@BindingAdapter("onLongClick")
fun View.setOnLongClick(clickListener: View.OnLongClickListener?) : Boolean {
    setOnLongClickListener(clickListener)
    return false
}

/* hide keyboard */
fun Activity.hideKeyboard() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

/* show keyboard */
fun Activity.showKeyboard() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

/* show keyboard */
fun Fragment.showKeyboard() {
    val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}