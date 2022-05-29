function aluno(nome, idade, sexo, turma) {
    const nomeAluno = nome;
    const idadeAluno = idade;
    const sexoAluno = sexo;
    let turmaAluno = turma;

    function imprimeDados() {
        console.log(`Nome: ${nomeAluno}; Idade: ${idadeAluno}; ` +
            `Sexo: ${sexoAluno}; Turma: ${turmaAluno}`);
    }

    function setTurma(turma) {
        turmaAluno = turma;
    }

    return {
        imprimeDados,
        setTurma
    }
}

const aluno2 = aluno('aluno', 20, 'M', '7C');
aluno2.imprimeDados();
aluno2.setTurma('8A')
aluno2.imprimeDados(); 