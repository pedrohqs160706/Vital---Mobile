//package br.senai.sp.jandira.vital.repository
//
//import android.content.Context
//
//class ContaRepository (context: Context){
//
//    // Acessar o banco de dados
//    private val db = ContaDb.getBancoDeDados(context).contaDao()
//
//
//    fun salvar(usuario: Usuario):Long{
//        return db.salvar(usuario)
//    }
//
////    fun listarTodosOsUsuarios ():List<Usuario>{
////
////    }
//
//
//    fun verificarLogin(email: String, senha: String): Boolean{
//        val usuario = db.buscarPeloEmail(email)
//        return usuario != null && usuario.senha == senha
//    }
//
//
//
//
//
//}
