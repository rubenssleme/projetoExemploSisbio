using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace projetoAgendaDeContatos.dominio
{
    class Contato
    {
        private int id;
        private String nome;
        private String endereco;
        private String telefone;
        private String eMail;

        public Contato()
        {
            
        }


        public Contato(int id, string nome, string endereco, string telefone, string eMail)
        {
            this._id = id;
            this._nome = nome;
            this._endereco = endereco;
            this._telefone = telefone;
            this._eMail = eMail;
        }

        public int _id { get => id; set => id = value; }
        public string _nome { get => nome; set => nome = value; }
        public string _endereco { get => endereco; set => endereco = value; }
        public string _telefone { get => telefone; set => telefone = value; }
        public string _eMail { get => eMail; set => eMail = value; }
    }
}
