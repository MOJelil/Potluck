import axios from 'axios';

const http = axios.create({
  
});


export default {

  list() {
    return axios.get('/potluck');
  },

  getPotluck(potluck_id) {
    return axios.get(`/potluck/${potluck_id}`);
  }, 

  createPotluck(potluck) {
    return axios.post('/potluck', potluck)
  },

  update(name, potluck) {
    return axios.put(`/potluck/${name}`, potluck);
  },

  delete(name) {
    return http.delete(`//${name}`);
  }

}
