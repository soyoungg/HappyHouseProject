<template>
  <div class="dashboard-div">
      <div>
        <span>
            <!-- {{house}} -->
        </span><br/>
      </div>
      <!-- chart -->
        <div class="dashboard-chart">

        </div>
      <div>
          
      </div>
  </div>
</template>

<script >
import http from "@/util/http-common";
import * as d3 from "d3";
// import {mapGetters} from "vuex";
export default {
    name:"userdashboard",
    props:{
        "house":String,
    },
    data: function() {
        return {
            "priceChange":[]
        };
    },
    computed: {
        // ...mapGetters(["priceChange"])
    },
    async created() {
        // await this.$store.dispatch("getPriceChange", this.$props.house);
        await http
        .post("/userboard/" + this.$store.getters.userInfo.user_id,
          {"user_id":this.$store.getters.userInfo.user_id, "aptname": this.house})
        .then((response) => {
          this.priceChange = response.data;
          console.log("response " , this.priceChange);
        })
        .catch(() => {
          alert("가격 변동 에러 발생");
        })
        drawChart(this.priceChange);
    },
    mounted() {
      // const width = 500;
      // const height = 500;
      // const margin = {top: 40, right: 40, bottom: 40, left: 40};
      // let data = this.priceChange;
      // console.log("data ", data);
      // for(var i = 0; i < data.length; i++) {
      //   data[i]["date"] = new Date(data[i]["date"]);
      //   console.log(data[i]["date"])
      // }
      // // const data = [
      // //   {date: new Date('2018-01-01'), dealamount: 10},
      // //   {date: new Date('2018-01-02'), dealamount: 20},
      // //   {date: new Date('2018-01-03'), dealamount: 30},
      // //   {date: new Date('2018-01-04'), dealamount: 25},
      // //   {date: new Date('2018-01-05'), dealamount: 35},
      // //   {date: new Date('2018-01-06'), dealamount: 45},
      // //   {date: new Date('2018-01-07'), dealamount: 60},
      // //   {date: new Date('2018-01-08'), dealamount: 50}
      // // ];
      
      // const x = d3.scaleTime()
      //   .domain(d3.extent(data, d => d.date))
      //   .range([margin.left, width - margin.right]);
      
      // const y = d3.scaleLinear()
      //   .domain([0, d3.max(data, d => d.dealamount)]).nice()
      //   .range([height - margin.bottom, margin.top]);
      
      // const xAxis = g => g
      //   .attr("transform", `translate(0,${height - margin.bottom})`)
      //   .call(d3.axisBottom(x).ticks(width / 90).tickSizeOuter(0));
      
      // const yAxis = g => g
      //   .attr("transform", `translate(${margin.left},0)`)
      //   .call(d3.axisLeft(y))
      //   .call(g => g.select(".domain").remove())
      //   .call(g => {
      //     return g.select(".tick:last-of-type text").clone()
      //       .attr("x", 3)
      //       .attr("text-anchor", "start")
      //       .attr("font-weight", "bold")
      //       .attr("font-size", '20px')
      //       .text('Y축')
      //     });
      
      // const line = d3.line()
      //   .defined(d => !isNaN(d.dealamount))
      //   .x(d => x(d.date))
      //   .y(d => y(d.dealamount));
      
      // const svg = d3.select('.dashboard-chart').append('svg').style('width', width).style('height', height);
      // svg.append("path")
      //   .datum(data)
      //   .attr("fill", "none")
      //   .attr("stroke", "steelblue")
      //   .attr("stroke-width", 1)
      //   .attr("stroke-linejoin", "round")
      //   .attr("stroke-linecap", "round")
      //   .attr("d", line);
      // svg.append('g').call(xAxis);
      // svg.append('g').call(yAxis);
      // svg.node();
    },

    methods: {
    }
}
function drawChart(_data) {
  const width = 500;
      const height = 500;
      const margin = {top: 40, right: 40, bottom: 40, left: 40};
      let data = _data;
      console.log("data ", _data);
      for(var i = 0; i < _data.length; i++) {
        data[i]["date"] = new Date(data[i]["date"]);
        // console.log(data[i]["date"])
      }
      
      const x = d3.scaleTime()
        .domain(d3.extent(data, d => d.date))
        .range([margin.left, width - margin.right]);
      
      const y = d3.scaleLinear()
        .domain([0, d3.max(data, d => d.dealamount)]).nice()
        .range([height - margin.bottom, margin.top]);
      
      const xAxis = g => g
        .attr("transform", `translate(0,${height - margin.bottom})`)
        .call(d3.axisBottom(x).ticks(width / 90).tickSizeOuter(0));
      
      const yAxis = g => g
        .attr("transform", `translate(${margin.left},0)`)
        .call(d3.axisLeft(y))
        .call(g => g.select(".domain").remove())
        .call(g => {
          return g.select(".tick:last-of-type text").clone()
            .attr("x", 3)
            .attr("text-anchor", "start")
            .attr("font-weight", "bold")
            .attr("font-size", '20px')
            .text(data[0]["aptname"])
          });
      
      const line = d3.line()
        .defined(d => !isNaN(d.dealamount))
        .x(d => x(d.date))
        .y(d => y(d.dealamount));
      
      const svg = d3.select('.dashboard-chart').append('svg').style('width', width).style('height', height);
      svg.append("path")
        .datum(data)
        .attr("fill", "none")
        .attr("stroke", "#f3c2db")
        .attr("stroke-width", 2)
        .attr("stroke-linejoin", "round")
        .attr("stroke-linecap", "round")
        .attr("d", line);
      svg.append('g').call(xAxis);
      svg.append('g').call(yAxis);
      svg.node();
}
</script>

<style>
.dashboard-div {
  min-height:500px;
}
</style>