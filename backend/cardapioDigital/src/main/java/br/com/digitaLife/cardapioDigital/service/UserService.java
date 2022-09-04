package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.exceptions.ObjectNotFoundException;
import br.com.digitaLife.cardapioDigital.model.UserModel;
import br.com.digitaLife.cardapioDigital.repository.UserRepository;
import br.com.digitaLife.cardapioDigital.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        UserModel userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(MessageUtils.getMessageComSubstituicao("usuario.username.naoEncontrado", username)));
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true,true, userModel.getAuthorities());
    }

    @Transactional(readOnly = true)
    public UserModel findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("usuario.id.naoEncontrado"));
    }
    public UserModel saveUser(UserModel userModel){
        return userRepository.save(userModel);
    }
    @Transactional(readOnly = true)
    public Page<UserModel> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }

}