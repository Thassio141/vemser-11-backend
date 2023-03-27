db.alunos.insert(
    {
        "nome":"Rafael Lazzari",
        "data_nascimento": new Date (1990,01,27)
    }
)

db.alunos.insert(
    {
        "nome":"Thassio",
        "data_nascimento": new Date (1990,01,27)
    }
)

db.alunos.insert(
    {
        "nome":"Lucas",
        "data_nascimento": new Date (1990,01,27)
    }
)

db.alunos.find(
    {
        "nome":"Thassio"
    }
)

db.alunos.find({})

db.alunos.findOne()