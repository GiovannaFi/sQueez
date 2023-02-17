package com.example.quiz2

object Constants{

    const val USER_NAME :String = "username"


    fun getQuestions() : ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()
        val que1 = Questions(
            1,
            "In che anno è nato Caravaggio?",
            "1550",
            "1571",
            "1664",
            "1460",
            2)

        val que2 = Questions(
            2,
            "Chi è l'autore dell'opera \"Metamorfosi di Narciso\" ?",
            "Michelangelo",
            "Leonardo da Vinci",
            "Modigliani",
            "Dalì",
            4)
        val que3 = Questions(
            3,
            "Chi ha scolpito \"amore e psiche\" conservata al Louvre?",
            "Canova",
            "Bernini",
            "Borromini",
            "Raffaello",
            1)
        val que4 = Questions(
            4,
            "Dove si trova il dipinto \"La Libertà che guida il popolo\" di Delacroix?",
            "Roma",
            "Berlino",
            "Parigi",
            "Firenze",
            3)
        val que5 = Questions(
            5,
            "Dove si trova \"Apollo e Dafne\" di Bernini?",
            "Roma",
            "Berlino",
            "Parigi",
            "Firenze",
            1)
        val que6 = Questions(
            6,
            "\"Ceci n'est pase une pipe\" è un'opera di? ",
            "Andy Warhol",
            "Rene Magritte",
            "Pablo Picasso",
            "Joan Mirò",
            2)
        val que7 = Questions(
            7,
            "Quale famoso quadro è stato trafugato a Palermo nel 1969?",
            "Annunciata di Palermo - Antonello da Messina",
            "La Natività - Caravaggio",
            "Cristo morto - Mantegna",
            "Sposalizio della Vergine - Raffaello",
            2)
        val que8 = Questions(
            8,
            "A quanti anni Michelangelo ha scolpito la Pietà di S.Pietro?",
            "22",
            "36",
            "31",
            "23",
            4)

        val que9 = Questions(
            9,
            "Chi è stato il fondatore del movimento artistico del Futurismo?",
            "Giacomo Balla",
            "Filippo Tommaso Marinetti",
            "Umberto Boccioni",
            "Kazimir Malevich",
            2)
        val que10 = Questions(
            10,
            "Quale pittore è considerato il padre del Rinascimento italiano?",
            "Michelangelo",
            "Leonardo da Vinci",
            "Raffaello Sanzio",
            "Tiziano",
            2)

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        return questionsList
    }
}