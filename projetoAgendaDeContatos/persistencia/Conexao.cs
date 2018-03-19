using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace projetoAgendaDeContatos.persistencia
{
   public class Conexao
    {
        private SqlConnection connection = new SqlConnection("User ID=sa;Initial Catalog=bdAgendaDeContatos1;Data Source=(local);Password= 1234567");

        public SqlConnection getConexao { get => connection; }

        public void abrirConexao()
        {
            if(this.connection.State == ConnectionState.Closed)
            {
                this.connection.Open();
            }
        }

        public void fecharConexao()
        {
            if(this.connection.State != ConnectionState.Closed)
            {
                this.connection.Close();
            }
        }

        public bool testarConexao()
        {
            if (this.connection != null && connection.State != ConnectionState.Closed)
                return true;
            else
                return false;

        }







    }
}
