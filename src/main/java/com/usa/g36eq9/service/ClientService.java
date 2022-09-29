package com.usa.g36eq9.service;

import com.usa.g36eq9.model.Client;
import com.usa.g36eq9.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }

    public Client save(Client c){
        if(c.getIdClient() == null){
            return clientRepository.save(c);
        }else{
            Optional<Client> caux = clientRepository.getClient(c.getIdClient());
            if(caux.isPresent()){
                return c;
            }else{
                return clientRepository.save(c);
            }
        }
    }
    public Client update(Client c){
        if(c.getIdClient() != null){
            Optional<Client> q = clientRepository.getClient(c.getIdClient());
            if(q.isPresent()){
                if(c.getName() != null){
                    q.get().setName(c.getName());
                }
                if(c.getEmail() != null){
                    q.get().setEmail(c.getEmail());
                }
                if(c.getPassword() != null){
                    q.get().setPassword(c.getPassword());
                }
                if(c.getAge() != null){
                    q.get().setAge(c.getAge());
                }
                if(c.getMessages() != null){
                    q.get().setMessages(c.getMessages());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean delete(int idClient){
        boolean flag = false;
        Optional<Client> c = clientRepository.getClient(idClient);
        if(c.isPresent()){
            clientRepository.delete(c.get());
            flag = true;
        }
        return flag;
    }
}
