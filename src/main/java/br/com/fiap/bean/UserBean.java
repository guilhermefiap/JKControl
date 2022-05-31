package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;
import br.com.fiap.service.UploadService;

@Named
@RequestScoped
public class UserBean {

	@Inject
	private User user;

	@Inject
	private UserDao dao;

	private UploadedFile image;

	public String save() {
		user.setImagePath(UploadService.write(image, "setups"));
		dao.create(user);
		return "users";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getAll() {
		return dao.listAll();
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

}
