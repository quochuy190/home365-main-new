package neo.vn.test365children

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


/**
 * @author HuyNQ52
 * Created 17/12/2021 at 12:03
 * Company: VHM
 * Email: huynq52@vingroup.net
 */
class ActivityDemoDragDropImage : AppCompatActivity() {

    @Volatile
    var state : State = State.INACTIVE

    enum class State {
        ACTIVE, INACTIVE, HANDLED
    }
    var questionContainer : LinearLayout? = null
    var answerContainer : LinearLayout? = null
    var answer_1 : FrameLayout? = null
    var answer_2 : FrameLayout? = null
    var answer_3: FrameLayout? = null
    var answer_4: FrameLayout? = null

    var quest_1 : FrameLayout? = null
    var quest_2 : FrameLayout? = null
    var quest_3 : FrameLayout? = null
    var quest_4 : FrameLayout? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_drag_drop_image)
        questionContainer = findViewById(R.id.questionContainer)
        answerContainer = findViewById(R.id.answerContainer)
        answer_1 = findViewById(R.id.fl_asw_1)
        answer_2 = findViewById(R.id.fl_asw_2)
        answer_3 = findViewById(R.id.fl_asw_3)
        answer_4 = findViewById(R.id.fl_asw_4)
        quest_1 = findViewById(R.id.fl_qes_1)
        quest_2 = findViewById(R.id.fl_qes_2)
        quest_3 = findViewById(R.id.fl_qes_3)
        quest_4 = findViewById(R.id.fl_qes_4)

        quest_1?.setOnDragListener(DragListener())
        quest_2?.setOnDragListener(DragListener())
        quest_3?.setOnDragListener(DragListener())
        quest_4?.setOnDragListener(DragListener())

        answer_1?.setOnTouchListener(DragItemTouchListener())
        answer_2?.setOnTouchListener(DragItemTouchListener())
        answer_3?.setOnTouchListener(DragItemTouchListener())
        answer_4?.setOnTouchListener(DragItemTouchListener())
        //bind()
    }

    private fun bind() {
        addQuestions()
        addAnswers()
    }

    @SuppressLint("InflateParams")
    private fun addQuestions() {
        val inflater = getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        for (i in 1..4) {
            val view = inflater.inflate(R.layout.item_question, null)
            view.setOnDragListener(DragListener())
            questionContainer?.addView(view)
        }
    }


    @SuppressLint("InflateParams")
    private fun addAnswers() {
        val inflater = getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        for (i in 1..4) {
            val view = inflater.inflate(R.layout.item_answer, null)
            view.setOnTouchListener(DragItemTouchListener())
            answerContainer?.addView(view)
        }
    }

    private inner class DragItemTouchListener : View.OnTouchListener {
        val ITEM_INDEX_D = "Index-From"
        @RequiresApi(Build.VERSION_CODES.N)
        override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
            return if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                dragMultiple(view)
                true
            } else {
                false
            }
        }

        @RequiresApi(Build.VERSION_CODES.N)
        private fun dragMultiple(view : View) {
            val data = ClipData.newPlainText("", "")
            val shadowBuilder = View.DragShadowBuilder(
                view
            )
            val parent = view.parent as ViewGroup
            view.tag = Pair(ITEM_INDEX_D,
                parent.indexOfChild(view))
            view.startDragAndDrop(data, shadowBuilder, view, 0)
            parent.removeView(view)
        }
    }


    private inner class DragListener : View.OnDragListener {

        override fun onDrag(v: View, event: DragEvent): Boolean {
            val view = event.localState as View
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    state = State.ACTIVE
                    Log.e("TAG", "onDrag: ACTION_DRAG_STARTED", )
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    Log.e("TAG", "onDrag: ACTION_DRAG_ENTERED", )

                }
                DragEvent.ACTION_DRAG_EXITED -> {
                    Log.e("TAG", "onDrag: ACTION_DRAG_EXITED", )

                }
                DragEvent.ACTION_DROP -> {
                    state = State.HANDLED
                    animateDropEffect(v as ViewGroup, event.localState as View)
                    return true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    Log.e("TAG", "onDrag: ACTION_DRAG_STARTED", )
                    if (state == State.ACTIVE) {
                        state = State.INACTIVE
                        animateMoveBack(view,
                            (view.tag as Pair<*, *>).second as Int)
                    }
                    return true
                }
                else -> {
                    Log.e("TAG", "onDrag: ACTION_DRAG_STARTED", )

                }
            }
            return true
        }

        private fun animateDropEffect(into: ViewGroup, view: View) {
            into.addView(view)
            val params = (view.layoutParams as FrameLayout.LayoutParams)
            params.gravity = Gravity.END
            view.layoutParams = params
            when(into.id){
                R.id.fl_qes_1 ->{
                    when (view.id){
                        R.id.fl_asw_1 ->{
                            Log.d("TAG", "animateDropEffect: 1_1")
                        }
                    }
                }
            }

        }
    }
    private fun animateMoveBack(view: View, index : Int) {
        answerContainer?.addView(view, index)
    }

    private fun animateDropEffect(into: View, view: View) {
        val parent = (into.parent as ViewGroup)
        parent.addView(view)

        val params = (view.layoutParams as FrameLayout.LayoutParams)
            .apply {
                gravity = Gravity.END
            }
        view.layoutParams = params
        //checkIsCorrect(parent)
    }

}