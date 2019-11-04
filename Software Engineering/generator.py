from ControlFlow import gen_cfg, to_graph
from graphviz import Source
cfg = gen_cfg(inspect.getsource(my_function))
graph = to_graph(cfg)
Source(graph)
