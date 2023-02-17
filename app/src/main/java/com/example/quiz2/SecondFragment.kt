package com.example.quiz2

import android.graphics.Color
import android.graphics.Typeface
import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.example.quiz2.databinding.ActivityMainBinding
import com.example.quiz2.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.currentCoroutineContext

class SecondFragment : Fragment() {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var next: Button? = null
    private var option1: Button? = null
    private var option2: Button? = null
    private var option3: Button? = null
    private var option4: Button? = null
    private var bar: ProgressBar? = null

    private var binding: FragmentSecondBinding? = null
    val binding2 get() = binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //when con key
        mQuestionsList = Constants.getQuestions()

        option1 = view.findViewById(R.id.option1)
        option2 = view.findViewById(R.id.option2)
        option3 = view.findViewById(R.id.option3)
        option4 = view.findViewById(R.id.option4)
        next = view.findViewById(R.id.next)
        bar = view.findViewById(R.id.bar)

        setQuestion()
        setUpOnClickListener()


    }

    private fun setUpOnClickListener() {
        option1?.setOnClickListener {
            selectedOptionView(it, 1)
        }
        option2?.setOnClickListener {
            selectedOptionView(it, 2)
        }
        option3?.setOnClickListener {
            selectedOptionView(it, 3)
        }
        option4?.setOnClickListener {
            selectedOptionView(it, 4)
        }
        next?.setOnClickListener {
            if (mSelectedOptionPosition == 0) {
                mCurrentPosition++

                when {
                    mCurrentPosition <= mQuestionsList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        view?.let { it1 ->
                            Snackbar.make(it1, "Hai completato il test!\nPunteggio: $mCorrectAnswers / ${bar?.max}", Toast.LENGTH_SHORT)
                                .show()
                        }
                        findNavController().navigateUp()
                    }
                }
            } else {
                val question = mQuestionsList?.get(mCurrentPosition - 1)
                if (question!!.correctAnswer != mSelectedOptionPosition) {
                    answerViewWrong(mSelectedOptionPosition)
                } else {
                    mCorrectAnswers++
                }
                answerViewCorrect(question.correctAnswer)

                if (mCurrentPosition == mQuestionsList!!.size) {
                    view?.findViewById<Button>(R.id.next)?.text = "termina"
                } else {
                    view?.findViewById<Button>(R.id.next)?.text = "prossima domanda"
                }
                mSelectedOptionPosition = 0
                option1?.isClickable = false
                option2?.isClickable = false
                option3?.isClickable = false
                option4?.isClickable = false
            }

        }
    }

    private fun setQuestion() {
        val questions = mQuestionsList!![mCurrentPosition - 1]
        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            view?.findViewById<Button>(R.id.next)?.text = "Termina"

        } else {
            view?.findViewById<Button>(R.id.next)?.text = "avanti"
        }

        val questionsMax = mQuestionsList!!.size
        bar?.max = questionsMax
        bar?.progress = mCurrentPosition
        view?.findViewById<TextView>(R.id.tv_progress)?.text = "$mCurrentPosition / $questionsMax"
        view?.findViewById<TextView>(R.id.questionLabel)?.text = questions.question.toString()
        option1?.text = questions.option1
        option2?.text = questions.option2
        option3?.text = questions.option3
        option4?.text = questions.option4


        option1?.isClickable = true
        option2?.isClickable = true
        option3?.isClickable = true
        option4?.isClickable = true

    }

    private fun defaultOptionsView() {
        val options = ArrayList<Button>()
        option1?.let { options.add(0, it) }
        option2?.let { options.add(1, it) }
        option3?.let { options.add(2, it) }
        option4?.let { options.add(3, it) }

        for (option in options) {
            option.setBackgroundColor(Color.parseColor("#FFFFFF"))
            option.typeface = Typeface.DEFAULT
        }
    }

    private fun answerViewWrong(answer: Int) {
        when (answer) {
            1 -> {
                option1?.setBackgroundColor(Color.RED)
            }
            2 -> {
                option2?.setBackgroundColor(Color.RED)
            }
            3 -> {
                option3?.setBackgroundColor(Color.RED)
            }
            4 -> {
                option4?.setBackgroundColor(Color.RED)
            }
        }
    }

    private fun answerViewCorrect(answer: Int) {
        when (answer) {
            1 -> {
                option1?.setBackgroundColor(Color.GREEN)
            }
            2 -> {
                option2?.setBackgroundColor(Color.GREEN)
            }
            3 -> {
                option3?.setBackgroundColor(Color.GREEN)
            }
            4 -> {
                option4?.setBackgroundColor(Color.GREEN)
            }
        }
    }

    private fun selectedOptionView(tv: View, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setBackgroundColor(Color.parseColor("#7A8089"))
    }


}