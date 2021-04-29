package br.com.zup

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("000.000.000-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.QA)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
                            .setLogradouro("Rua das Tabajaras")
                            .setCep("00000-000")
                            .setComplemento("Casa 20")
                            .build())
        .build()

    // escrevemos o objeto
    println(request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    // lemos o objeto
    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE)
        .build()

    println(request2)

}