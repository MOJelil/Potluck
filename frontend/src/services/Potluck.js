import axios from 'axios';

const http = axios.create({
  
});


export default {

  list() {
    return axios.get('/potluck');
  },

  getPotluck(potluck_id) {
    return http.get(`/potluck/${potluck_id}`);
  }, 
  createPotluck(potluck) {
    return axios.post('/potluck', potluck)

  },
  update(name, potluck) {
    return http.put(`//${name}`, potluck);
  },
  delete(name) {
    return http.delete(`//${name}`);
  }

}
