db.especialidade.insert(
    {
        "nome":"Cardiologista",
        "valor": 450.45
    }
)

db.especialidade.insert(
    {
        "nome":"Pediatra",
        "valor": 250
    }
)

db.especialidade.insert(
    {
        "nome":"Imunologista",
        "valor": 300
    }
)

db.especialidade.insert(
    {
        "nome":"Fisioterapeuta",
        "valor": 200
    }
)


// Select
db.especialidade.find(
    {
        "nome":"Fisioterapeuta"
    }
)


db.especialidade.find(
    {
        "valor":250
    }
)

db.especialidade.find({})

db.especialidade.findOne()

db.especialidade.find({nome: /^Fisio/})