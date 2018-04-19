using projetoAgendaDeContatos.dominio;
using projetoAgendaDeContatos.persistencia;
using System;
using System.Data.SqlClient;

namespace projetoAgendaDeContatos.repositorio
{
    class RepositorioContato
    {
        Conexao conexao = new Conexao();

        public bool Incluir(Contato contato)
        {
            bool retorno = false;
            try
            {
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conexao.getConexao;
                //select @@IDENTITY me traz o ultimo codigo registrado dessa tabela
                cmd.CommandText = "insert into contatos values(@nome,@endereco,@telefone,@eMail);";
                cmd.Parameters.AddWithValue("@nome", contato._nome);
                cmd.Parameters.AddWithValue("endereco", contato._endereco);
                cmd.Parameters.AddWithValue("@telefone", contato._telefone);
                cmd.Parameters.AddWithValue("@eMail", contato._eMail);
                conexao.abrirConexao();
                //executar o cmd retornado um valor
                cmd.ExecuteScalar();
                retorno = true;
            }catch(Exception e){
                retorno = false;
                conexao.fecharConexao();
            }
            return retorno;
        }




    }
}
